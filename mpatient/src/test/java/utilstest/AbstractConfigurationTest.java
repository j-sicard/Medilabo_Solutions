package utilstest;

import com.mpatient.mpatient.MpatientApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MpatientApplication.class)
@Sql(scripts = { "classpath:data-test.sql" })
@ActiveProfiles("test")
public class AbstractConfigurationTest {
}
