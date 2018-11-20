package cordova.plugin.activity.recognition;

import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;


public class ActivityRecognitionIntentService extends IntentService 
{
	public static ActivityRequestResult Activity;
	
	public ActivityRecognitionIntentService()
	{
        super("ActivityRecognitionIntentService");
    }
	
	private String ConvertActivityCodeToString(DetectedActivity Activity)
	{
		if(Activity.getType() === DetectedActivity.IN_VEHICLE){
			return "In Vechicle";
		}else if(Activity.getType() === DetectedActivity.ON_BICYCLE){
			return "On Bicycle";
		}else if(Activity.getType() === DetectedActivity.ON_FOOT){
			return "On Bicycle";
		}else if(Activity.getType() === DetectedActivity.RUNNING){
			return "On Bicycle";
		}else if(Activity.getType() === DetectedActivity.STILL){
			return "On Bicycle";
		}else if(Activity.getType() === DetectedActivity.TILTING){
			return "On Bicycle";
		}else if(Activity.getType() === DetectedActivity.WALKING ){
			return "On Bicycle";
		}else{
			return "Can Not Recognize";
		}
	}
	
	@Override
	protected void onHandleIntent(Intent intent) 
	{
		try
		{
			if(ActivityRecognitionResult.hasResult(intent)) 
			{
				ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
				DetectedActivity CurrentActivity = result.getMostProbableActivity();
				
				Activity.ActivityType = ConvertActivityCodeToString(CurrentActivity);
				Activity.Propability = CurrentActivity.getConfidence();	
			}
			else 
			{
				Activity.ActivityType = "NoResult";
			}
		}
		catch (Exception e)
        {
           
        }
	}
    
}
