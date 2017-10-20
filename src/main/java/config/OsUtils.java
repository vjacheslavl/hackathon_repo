package config;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

public final class OsUtils
{
    private static String OS = null;
    public static String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    public static boolean isWindows()
    {
        return getOsName().toLowerCase().contains("win");
    }

    public static boolean isUnix() {
        return getOsName().toLowerCase().contains("darwin");
    }
}
