package com.bs.hrm.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bs.hrm.entity.Loan;
import com.bs.hrm.entity.Menu;
import com.bs.hrm.entity.ids.MenuId;

@Repository
//public interface MenuRepo extends JpaRepository<Menu, Long>{
public interface MenuRepo extends JpaRepository<Menu, MenuId>{

	//public Menu	findTopBySystemIdOrderBySystemIdDesc(int systemId);
	public Optional<Menu>	findBySystemIdAndSubSystemIdAndFunctionId(Integer systemId,
			Integer subSystemId, Integer functionId);
	
//	select system_id from hrdb.menu group by system_id desc;
	@Query(value = "select system_id from hrdb.menu group by system_id desc limit 1", 
			  nativeQuery = true)
	public Integer findLastSystemId();
	
	@Query(value = "select sub_system_id from hrdb.menu where system_id =:systemId"
			+ " order by sub_system_id desc limit 1;", 
			  nativeQuery = true)
	public Integer findLastSubSystemIdOfSystemId(@Param("systemId") Integer systemId);
	
	@Query(value = "select function_id from hrdb.menu where system_id=:systemId"
			+ " and sub_system_id=:subSystemId order by function_id desc limit 1;", 
			  nativeQuery = true)
	public Integer findLastFunctionIdOfSystemIdAndSubSystemId(
			@Param("systemId") Integer systemId, @Param("subSystemId") Integer subSystemId);
	
//	@Query(value = "select system_id, function_name from hrdb.menu "
//			+ "group by system_id order by function_name;", nativeQuery = true)
	@Query(value = "select m.systemId, m.functionName from Menu m group by"
			+ " m.systemId order by m.functionName")
	public List<Object[]> findAllSystemIdWithFunctionName();
	
	@Query(value = "select m from Menu m group by"
			+ " m.systemId order by m.functionName")
	public List<Menu> findAllSystem();
	
	@Query(value = "select m.subSystemId, m.functionName from Menu m where"
			+ " m.systemId =:systemId and m.subSystemId !=0 group by"
			+ " m.subSystemId order by m.functionName")
	public List<Object[]> findAllSubSystemIdWithName(@Param("systemId") Integer systemId);
	
	@Query(value = "SELECT * FROM hrdb.menu where function_id > 0 order by function_name asc;",
			  nativeQuery = true)
	public List<Menu> findAllFunction();
}
