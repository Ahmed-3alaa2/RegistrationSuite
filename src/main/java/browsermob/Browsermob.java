package browsermob;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

public class Browsermob {
	// initialize proxy to monitor request and save response in har file
	BrowserMobProxy proxy = new BrowserMobProxyServer();
	public BrowserMobProxy Proxy() {
		return proxy;
	}

	public DesiredCapabilities capabilites() {
		proxy.start();
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT,CaptureType.REQUEST_HEADERS,CaptureType.RESPONSE_HEADERS);
		proxy.newHar("PhpTravel");
		return capabilities;
	}
}
