package hh.harjoitus.Kpopgroup;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.harjoitus.Kpopgroup.web.KpopgroupController;
import hh.harjoitus.Kpopgroup.web.MemberController;
import hh.harjoitus.Kpopgroup.web.UserController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class KpopgroupApplicationTests {

	@Autowired
	private KpopgroupController kpopgroupController;
	
	@Autowired
	private MemberController memberController;
	
	@Autowired
	private UserController userController;


	@Test
	void contextLoads() throws Exception {
		assertThat(kpopgroupController).isNotNull();
	}
	
	@Test
	void contextLoads2() throws Exception {
		assertThat(memberController).isNotNull();
	}
	
	@Test
	void contextLoads3() throws Exception {
		assertThat(userController).isNotNull();
	}

}
