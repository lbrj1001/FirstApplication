package test.lifeng.liang;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;


abstract class AbstractSingleTask extends AsyncTask<String, Integer, Boolean>{
	private ProgressDialog mDialogWait;
	private Context mContext;
	private ITaskCallback mResultListener;
	
	protected String mResultObj;
	private boolean showDialog = true;

	public AbstractSingleTask(Context context) {
		this.mContext = context;
		mDialogWait = new ProgressDialog(context);
		mDialogWait.setTitle("正在请求");
		mDialogWait.setMessage("等待中。。。");
		mDialogWait.setIndeterminate(true);
		mDialogWait.setCancelable(false);
	}
	@Override
	protected void onPreExecute() {
		mDialogWait.show();
	}

	@Override
	protected Boolean doInBackground(String... params) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mResultObj = queryAction(params);
		return true;
	}
	
	@Override
	protected void onPostExecute(Boolean result) {
		if(showDialog) mDialogWait.dismiss();
		mResultListener.succeed(mResultObj);
	}
	
	public void setTaskCallback(ITaskCallback listener) {
		this.mResultListener = listener;
	}
	
	abstract String queryAction(String... params);
}
