package prakash.misc.log4j2;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;

@Plugin(name = "ObfuscatePIIDataRewritePolicy", category = Core.CATEGORY_NAME, elementType = "rewritePolicy", printObject = true)
public final class ObfuscatePIIDataRewritePolicy implements RewritePolicy {

	@Override
	public LogEvent rewrite(final LogEvent event) {
		System.out.println("sop rewrite");
//		if(event.getMessage().getFormattedMessage().matches("^[sS][sS][nN]*$|^[pP][a-zA-Z]*[dD]$")) {
		if (event.getMessage().getFormattedMessage().matches("^[sS][sS][nN].*$|^[pP][a-zA-Z]{2,6}[dD].*$")) {		
			System.out.println("sop contains sensitive data");
			Message rewritten = new SimpleMessage(event.getMessage().getFormattedMessage().replaceAll("[a-zA-Z0-9]", "X"));
			return new Log4jLogEvent.Builder(event).setMessage(rewritten).build();
		}
		return event;
	}

	@PluginFactory
	public static ObfuscatePIIDataRewritePolicy createPolicy() {
		return new ObfuscatePIIDataRewritePolicy();
	}
}