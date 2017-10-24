package com.pisight.everest.constants;

public interface QueryConstant {

	String GET_USER_BY_USERNAME = "select u from User u where u.username = :username";
	
	String GET_USER_BY_EMAIL = "select u from User u where u.email = :email";
	
	String GET_USER_ROLE_BY_ROLE="select u from UserRole u where u.role = :role";
	
	String GET_CARRIER_BY_NAME = "select carrier from Carrier carrier where carrier.name = :name";
	
	String GET_CARRIER_BY_ABBR = "select carrier from Carrier carrier where carrier.abbreviation = :abbreviation";
	
	String GET_DEPT_BY_NAME = "select dept from Department dept where dept.departmentName = :name";
	
	String GET_DEPT_BY_DEPT_ID = "select dept from Department dept where dept.departmentId = :deptId";

	String GET_DROPDOWNLIST_BY_TYPE_VALUE = "select ddl from DropDownList ddl where ddl.type.name = :type and ddl.value = :value";

	String GET_DROPDOWNTYPE_BY_NAME = "select ddt from DropDownType ddt where ddt.name = :name"; 

	String GET_EMPLOYEE_BY_USER_ID = "select emp from Employee emp where emp.user.id = :userId";

	String GET_EMPLOYEE_BY_EMP_ID = "select emp from Employee emp where emp.employeeId = :empId";

	String GET_ADVISOR_BY_EMP_ID = "select advisor from  Advisor advisor where advisor.employee= empId";

	String GET_IND_CLIENT_MAP_BY_ADVISOR_ID = "select client From AdvisorIndividualClientMap client where client.advisor.id= :advisorId";

	String GET_BUSINESS_CLIENT_MAP_BY_ADVISOR_ID = "select client From AdvisorBusinessClientMap client where client.advisor.id= :advisorId ";

	String GET_POLICY_PLANS_BY_CARRIER_ID = "select policyplan from PolicyPlan policyplan where policyplan.carrier.id= :carrierId";

	String GET_POLICY_PLANS_BY_NAME = "select policyplan from PolicyPlan policyplan where policyplan.name= :name";

	String GET_RIDERCOMMISIONRATE_BY_POLICYPLAN_ID = "select ridercommisonRate from RiderCommissionRate ridercommisonRate where ridercommisonRate.policyPlanRider.id= :riderId";

}
