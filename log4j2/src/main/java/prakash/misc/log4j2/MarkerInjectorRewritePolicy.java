package prakash.misc.log4j2;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(name = "InjectMarkerPolicy", category = "Core", elementType = "rewritePolicy", printObject = true)
public final class MarkerInjectorRewritePolicy implements RewritePolicy {

	@Override
	public LogEvent rewrite(LogEvent event) {
		System.out.println("rewrite");
		System.out.println(event.getMessage());
		return event;
	}

	@PluginFactory
	public static MarkerInjectorRewritePolicy createPolicy() {
		return new MarkerInjectorRewritePolicy();
	}
}
