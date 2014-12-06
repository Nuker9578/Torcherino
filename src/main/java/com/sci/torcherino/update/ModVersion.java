package com.sci.torcherino.update;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class ModVersion
{
    private static final ModVersion NULL_VERSION = new ModVersion(0, 0, 0, 0);

    private int mc;
    private int major;
    private int minor;
    private int patch;

    public ModVersion(final int mc, final int major, final int minor, final int patch)
    {
        this.mc = mc;
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public static ModVersion parse(final String version)
    {
        if (version.equals("@VERSION@"))
            return NULL_VERSION;

        try
        {
            final String[] parts = version.split("\\.");

            return new ModVersion(
                    Integer.valueOf(parts[0]),
                    Integer.valueOf(parts[1]),
                    Integer.valueOf(parts[2]),
                    Integer.valueOf(parts[3])
            );
        }
        catch (Throwable t)
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return this.mc + "." + this.major + "." + this.minor + "." + this.patch;
    }

    public boolean isNewer(final ModVersion newer)
    {
        if (newer.mc > this.mc)
        {
            return true;
        }
        else
        {
            if (newer.major > this.major)
            {
                return true;
            }
            else
            {
                if (newer.minor > this.minor)
                {
                    return true;
                }
                else
                {
                    if (newer.patch > this.patch)
                        return true;
                }
            }
        }
        return false;
    }
}