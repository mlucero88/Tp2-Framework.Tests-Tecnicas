package grupo11.frameworktests;


public class UnitTestResult extends TestResult {
	
	private String result;
	public enum ResultType {Ok, Fail, Error}
	private static ResultType resultType;
	
	
	static UnitTestResult createSuccessfulResult(String testName) {
		resultType = (ResultType.Ok);
		return new UnitTestResult(testName, "");
	}

	static UnitTestResult createFailedResult(String testName, String failureMessage) {
		resultType = (ResultType.Fail);
		return new UnitTestResult(testName, failureMessage);
	}

	static UnitTestResult createErrorResult(String testName, String errorMessage) {
		resultType = (ResultType.Error);
		return new UnitTestResult(testName, errorMessage);
	}

	public String getMessage() {
		return result;
	}
	
	public ResultType getResultType (){
		return resultType;
	}
	
	protected UnitTestResult(String testName, String resultMessage) {
		super(testName);
		result = "[" + resultType + "] " + testName + ": " +resultMessage;
	}
	
	@Override
	public boolean add(TestResult test){
		return false;
	}
	
	@Override
	public void setTiempoEjecucion (double tiempo){
		tiempoEjecucion = tiempo;
		result = result + " (" + tiempoEjecucion + " ms)";
	}
	
	public void setCollectionResultCadenaDeNombres(String contenedora){}
	
	public String getCollectionResultCadenaDeNombres(){ 
		return null;
	}
	
	public void registrarResultadoEnReporte(TestReport report){
		report.registrarUnitTestResult(resultType, result);
	}
	
	
}
