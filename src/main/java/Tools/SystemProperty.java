/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javax.swing.SwingWorker;

/**
 *
 * @author patryk
 */
public class SystemProperty extends SwingWorker {

    @Override
    protected Object doInBackground() throws Exception {

        while (!Global.EndProcess) {
            Thread.sleep(1000);
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().startsWith("get")
                        && Modifier.isPublic(method.getModifiers())) {
                    Object value;
                    try {
                        value = method.invoke(operatingSystemMXBean);
                    } catch (Exception e) {
                        value = e;
                    } // try
                    String SysProp = method.getName() + " = " + value;
                    if (SysProp.contains("getCommittedVirtualMemorySize")) {
                        Global.CommittedVirtualMemorySize.add(SysProp);
                    }
                    if (SysProp.contains("getFreePhysicalMemorySize")) {
                        Global.FreePhysicalMemorySize.add(SysProp);
                    }
                    if (SysProp.contains("getProcessCpuLoad")) {
                        Global.ProcessCpuLoad.add(SysProp);
                    }
                    if (SysProp.contains("getSystemCpuLoad")) {
                        Global.SystemCpuLoad.add(SysProp);
                    }
                    //System.out.println(SysProp);
                } // if
            } // for
        }
        return null;
    }

}
