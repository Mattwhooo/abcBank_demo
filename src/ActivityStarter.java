

import com.example.abcbank.abcBankBrain;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ActivityStarter implements OnClickListener {

	private Class<?> c;
	private Activity activity;
	private abcBankBrain brain = new abcBankBrain();

	
	public ActivityStarter(Activity activity, Class<?> c){
		this.activity = activity;
		this.c = c;
		
	}
	
	public ActivityStarter(Activity activity, Class<?> c, abcBankBrain brain){
		this.activity = activity;
		this.c = c;
		this.brain  = brain;
	}
	

	@Override
	public void onClick(View v) {
		
		
		
		Intent intent = new Intent(activity, c);
		intent.putExtra("brain", this.brain);
		activity.startActivity(intent);
	}
	
		
}
