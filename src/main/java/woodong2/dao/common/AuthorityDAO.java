package woodong2.dao.common;

import java.util.List;

import org.springframework.stereotype.Repository;

//AUTHORITY에 접근하는 DAO 클래스

@Repository("authorityDAO")
public class AuthorityDAO extends AbstractDAO{
	
	public List<String> getAuthorities(String username) {
		return (List<String>)selectList("authority.getAuthorities",username);
	}
	
}
