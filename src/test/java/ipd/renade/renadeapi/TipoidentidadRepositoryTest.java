package ipd.renade.renadeapi;

import ipd.renade.renadeapi.repository.ITipoidentidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(value = false)//true: la prueba no se almacena en el bd - false: la prueba se almacena en le bd
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TipoidentidadRepositoryTest {
    @Autowired
    private ITipoidentidadRepository tipoidentidadRepository;



}
