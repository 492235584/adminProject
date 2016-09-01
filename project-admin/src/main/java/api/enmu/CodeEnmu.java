package api.enmu;

public enum CodeEnmu {
	/*
	 * 以下为系统定义code
	 */
	succ("0000000",null),
	paramEmpty("0000001","参数为空"),
	paramLack("0000002","参数不足"),
	dataExist("0000003","数据已存在"),
	dataNotExist("0000004","数据不存在"),
	dbException("0000005","数据库异常"),
	paramError("0000006","参数错误"),

	example("",""),
	;
	private String code;
	private String msg;
	private CodeEnmu(String code,String msg){
		this.code = code;
		this.msg= msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
