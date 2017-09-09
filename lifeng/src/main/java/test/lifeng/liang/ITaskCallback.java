package test.lifeng.liang;

public interface ITaskCallback {
	void succeed(Object... params);
	void failed(Object... params);
}
