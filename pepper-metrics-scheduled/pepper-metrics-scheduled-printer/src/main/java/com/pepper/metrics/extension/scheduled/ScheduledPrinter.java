package com.pepper.metrics.extension.scheduled;

import com.pepper.metrics.core.ScheduledRun;
import com.pepper.metrics.core.Stats;
import com.pepper.metrics.core.extension.ExtensionLoader;
import com.pepper.metrics.core.extension.SpiMeta;

import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  Description:
 *      Performance日志打印插件
 *
 *  Notes:
 *      框架中只基于slf4j，不集成任何日志框架的实现，用户需要自行依赖日志实现
 *      需要有一个名为[performance]的appender才能打到日志中，否则会打到默认的root中
 *
 *
 * </pre>
 * @author zhiminxu
 * @package com.pepper.metrics.extension.scheduled
 * @create_time 2019-08-07
 */
@SpiMeta(name = "printer")
public class ScheduledPrinter implements ScheduledRun {

    @Override
    public void run(Set<Stats> statsSet) {
        final List<PerfPrinter> perfPrinters = ExtensionLoader.getExtensionLoader(PerfPrinter.class).getExtensions();
        for (PerfPrinter perfPrinter : perfPrinters) {
            perfPrinter.print(statsSet);
        }
    }

}
