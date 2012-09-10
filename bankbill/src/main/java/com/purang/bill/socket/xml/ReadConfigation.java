package com.purang.bill.socket.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Company :普兰科技
 * Create User:周明
 * Create Date:12-9-3
 * Create Time:下午7:55
 */
public class ReadConfigation {
    private static final String PFILE = "Config.properties";
    private File m_file = null;
    private long m_lastModifiedTime = 0;
    private Properties m_props = null;

    private static ReadConfigation m_instance = new ReadConfigation();

    private ReadConfigation() {
        m_file = new File(PFILE);
        m_lastModifiedTime = m_file.lastModified();
        if (m_lastModifiedTime == 0) {
            System.err.println(PFILE + " file does not exist!");
        }
        m_props = new Properties();
        try {
            m_props.load(new FileInputStream(PFILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public static ReadConfigation getInstance() {
        return m_instance;
    }

    public String getConfigItem(String name, String defaultVal) {
        long newTime = m_file.lastModified();
        if (newTime == 0) {
            if (m_lastModifiedTime == 0) {
                System.err.println(PFILE + " file does not exist!");
            } else {
                System.err.println(PFILE + " file was deleted!!");
            }
            return defaultVal;
        } else if (newTime > m_lastModifiedTime) {
            m_props.clear();
            try {
                m_props.load(new FileInputStream(PFILE));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m_lastModifiedTime = newTime;
        String val = m_props.getProperty(name);
        if (val == null) {
            return defaultVal;
        } else {
            return val;
        }
    }

    public String getConfigItem(String name) {
        return getConfigItem(name, "");
    }
}