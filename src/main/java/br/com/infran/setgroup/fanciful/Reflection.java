package br.com.infran.setgroup.fanciful;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;

public final class Reflection {
    private static String _versionString;
    private static final Map<String, Class<?>> _loadedNMSClasses = new HashMap();
    private static final Map<String, Class<?>> _loadedOBCClasses = new HashMap();
    private static final Map<Class<?>, Map<String, Field>> _loadedFields = new HashMap();
    private static final Map<Class<?>, Map<String, Map<ArrayWrapper<Class<?>>, Method>>> _loadedMethods = new HashMap();

    private Reflection() {
    }

    public static synchronized String getVersion() {
        if (_versionString == null) {
            if (Bukkit.getServer() == null) {
                return null;
            }

            String name = Bukkit.getServer().getClass().getPackage().getName();
            _versionString = name.substring(name.lastIndexOf(46) + 1) + ".";
        }

        return _versionString;
    }

    public static synchronized Class<?> getNMSClass(String className) {
        if (_loadedNMSClasses.containsKey(className)) {
            return (Class)_loadedNMSClasses.get(className);
        } else {
            String fullName = "net.minecraft.server." + getVersion() + className;
            Class clazz = null;

            try {
                clazz = Class.forName(fullName);
            } catch (Exception var4) {
                var4.printStackTrace();
                _loadedNMSClasses.put(className, (Class<?>) null);
                return null;
            }

            _loadedNMSClasses.put(className, clazz);
            return clazz;
        }
    }

    public static synchronized Class<?> getOBCClass(String className) {
        if (_loadedOBCClasses.containsKey(className)) {
            return (Class)_loadedOBCClasses.get(className);
        } else {
            String fullName = "org.bukkit.craftbukkit." + getVersion() + className;
            Class clazz = null;

            try {
                clazz = Class.forName(fullName);
            } catch (Exception var4) {
                var4.printStackTrace();
                _loadedOBCClasses.put(className, (Class<?>) null);
                return null;
            }

            _loadedOBCClasses.put(className, clazz);
            return clazz;
        }
    }

    public static synchronized Object getHandle(Object obj) {
        try {
            return getMethod(obj.getClass(), "getHandle").invoke(obj);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static synchronized Field getField(Class<?> clazz, String name) {
        Object loaded;
        if (!_loadedFields.containsKey(clazz)) {
            loaded = new HashMap();
            _loadedFields.put(clazz, (Map<String, Field>) loaded);
        } else {
            loaded = (Map)_loadedFields.get(clazz);
        }

        if (((Map)loaded).containsKey(name)) {
            return (Field)((Map)loaded).get(name);
        } else {
            try {
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                ((Map)loaded).put(name, field);
                return field;
            } catch (Exception var4) {
                var4.printStackTrace();
                ((Map)loaded).put(name, (Object)null);
                return null;
            }
        }
    }

    public static synchronized Method getMethod(Class<?> clazz, String name, Class<?>... args) {
        if (!_loadedMethods.containsKey(clazz)) {
            _loadedMethods.put(clazz, new HashMap());
        }

        Map<String, Map<ArrayWrapper<Class<?>>, Method>> loadedMethodNames = (Map)_loadedMethods.get(clazz);
        if (!loadedMethodNames.containsKey(name)) {
            loadedMethodNames.put(name, new HashMap());
        }

        Map<ArrayWrapper<Class<?>>, Method> loadedSignatures = (Map)loadedMethodNames.get(name);
        ArrayWrapper<Class<?>> wrappedArg = new ArrayWrapper(args);
        if (loadedSignatures.containsKey(wrappedArg)) {
            return (Method)loadedSignatures.get(wrappedArg);
        } else {
            Method[] var9;
            int var8 = (var9 = clazz.getMethods()).length;

            for(int var7 = 0; var7 < var8; ++var7) {
                Method m = var9[var7];
                if (m.getName().equals(name) && Arrays.equals(args, m.getParameterTypes())) {
                    m.setAccessible(true);
                    loadedSignatures.put(wrappedArg, m);
                    return m;
                }
            }

            loadedSignatures.put(wrappedArg, (Method) null);
            return null;
        }
    }
}