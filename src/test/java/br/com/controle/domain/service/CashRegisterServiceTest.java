/**
 * 
 */
package br.com.controle.domain.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.controle.domain.model.CashRegister;
import br.com.controle.domain.repository.CashRegisterRepository;

/**
 * @author Gabriel Rocha
 */
@RunWith(SpringRunner.class)
class CashRegisterServiceTest {

	@Mock
	private CashRegisterRepository repository;

	@InjectMocks
	private CashRegisterService service;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test method for
	 * {@link br.com.controle.domain.service.CashRegisterService#save(java.lang.Object)}.
	 */
	@Test
	final void testSave() {
		when(repository.save(any())).thenReturn(mock(CashRegister.class));
		CashRegister entity = service.save(any());
		assertNotNull(entity);
		verify(repository, times(1)).save(any());
	}

	/**
	 * Test method for
	 * {@link br.com.controle.domain.service.CashRegisterService#update(java.lang.Object)}.
	 */
	@Test
	final void testUpdate() {

		CashRegister casshRegister = new CashRegister();
		casshRegister.setId(1l);
		when(repository.existsById(any())).thenReturn(true);
		when(repository.findById(any())).thenReturn(Optional.of(casshRegister));

		CashRegister entity = service.update(casshRegister);
		assertNotNull(entity);
		verify(repository,times(1)).findById(any());
	}

	/**
	 * Test method for
	 * {@link br.com.controle.domain.service.CashRegisterService#existsById(long)}.
	 */
	@Test
	final void testExistsById() {
		when(repository.existsById(any())).thenReturn(true);
		
		boolean exists = service.existsById(1l);
		
		assertTrue(exists);
		verify(repository, times(1)).existsById(any());
	}

	/**
	 * Test method for
	 * {@link br.com.controle.domain.service.CashRegisterService#openCashRegister(java.lang.Long)}.
	 */
	@Test
	final void testOpenCashRegister() {
		
		CashRegister cashRegister = new CashRegister();
		cashRegister.setTotalClosure(BigDecimal.ONE);
		
		when(repository.existsById(any())).thenReturn(true);
		when(repository.findById(1l)).thenReturn(Optional.of(cashRegister));
		
		boolean retorno = service.openCashRegister(1l);
		
		assertTrue(retorno);
	}

}