package prakash.misc.log4j2;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.ContextDataFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.util.StringMap;

@Plugin(name = "ObfuscatePIIDataRewritePolicy", category = Core.CATEGORY_NAME, elementType = "rewritePolicy", printObject = true)
public final class ObfuscatePIIDataRewritePolicy implements RewritePolicy {

	@Override
	public LogEvent rewrite(final LogEvent event) {
		System.out.println("sop rewrite");
		return event;
	}

	@PluginFactory
	public static ObfuscatePIIDataRewritePolicy createPolicy() {
		return new ObfuscatePIIDataRewritePolicy();
	}
}