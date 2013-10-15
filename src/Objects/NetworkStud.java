package Objects;

import java.io.IOException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.AsyncTask;

public class NetworkStud extends  AsyncTask<Object, Object, Object> implements ConnectionEventListener{
	NetworkStudListener e;
	HttpClient client;
	HttpPost post ;
	boolean connFlag = true;

	public NetworkStud() {
		 super();
		
		// TODO Auto-generated constructor stub
	}

	

	private String url = "http://mtestorasi-suda.rhcloud.com/health_check.php";
	
	
	
	//used for sending a post entity 
	
	
	
	
	public void startSend() 
	{
		
		HttpParams httpParameters = new BasicHttpParams();
		// Set the timeout in nanoseconds until a connection is established.
		// The default value is zero, that means the timeout is not used. 
		int timeoutConnection = 2000;//20 seconds time out
		HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		// Set the default socket timeout (SO_TIMEOUT) 
		// in nanoseconds which is the timeout for waiting for data.
		int timeoutSocket = 3000; //30 seconds time out
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		
		client = new DefaultHttpClient(httpParameters);
		
		post = new HttpPost(url);
		StringBuffer stringBuffer = new StringBuffer("Hello World");
		for(int i = 0; i<100000; i ++)
		{
			stringBuffer.append("H");
		}
		
	//TODO	
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		Log.i("hayes","sting object");
		
		//for more packets can just add more value pairs or change stringbuffer loop size
		pairs.add(new BasicNameValuePair("key", stringBuffer.toString()));
		pairs.add(new BasicNameValuePair("key2", stringBuffer.toString()));
		pairs.add(new BasicNameValuePair("key3", stringBuffer.toString()));
		pairs.add(new BasicNameValuePair("key4", stringBuffer.toString()));
		pairs.add(new BasicNameValuePair("key5", stringBuffer.toString()));
		pairs.add(new BasicNameValuePair("key6", stringBuffer.toString()));
		try {
			Log.i("hayes","added string object to post entity");
			post.setEntity(new UrlEncodedFormEntity(pairs));
			
			client.execute(post);
			Log.i("hayes","sent post");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			connFlag = false;
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			connFlag = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			connFlag = false;
			e.printStackTrace();
		}
		Log.i("hayes","data off to http://mtestorasi-suda.rhcloud.com/health_check.php");
		e.networkStudDone();
	}


	@Override
	public void connectionClosed(ConnectionEvent arg0) {
		// TODO Auto-generated method stub
		Log.i("hayes","connectionClosed");
		
		e.networkStudDone();
		
	}

	@Override
	public void connectionErrorOccurred(ConnectionEvent arg0) {
		// TODO Auto-generated method stub
		e.networkStudDone();
	}

	


	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		Log.i("hayes", "start of sending");
		this.startSend();
		return null;
	}
	//for a object to add it self as a listner
	public void addNetworkStudListener(NetworkStudListener listener)
    {
        e = listener;
    }

}
