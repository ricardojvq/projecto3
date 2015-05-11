package projecto3.grupo3.rafaelaricardo;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionTOutListener implements HttpSessionListener {
	
	@Inject MsgBean msgBean;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession httpSession = se.getSession();
		long lastAccessedTime = httpSession.getLastAccessedTime();
	    int maxInactiveTime = httpSession.getMaxInactiveInterval();
	    long currentTime = System.currentTimeMillis();
	    boolean possibleSessionTimeout = (currentTime-lastAccessedTime) >= (maxInactiveTime*1000);

		// TODO Auto-generated method stub
		if (possibleSessionTimeout) {
			msgBean.timedOut();
		}
		
	}

}
