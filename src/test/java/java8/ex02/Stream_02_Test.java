package java8.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Order;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

	@Test
	public void test_map() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des clients associés aux commandes
		// List<Customer> result = null;
		List<Customer> result = orders.stream().map(p -> p.getCustomer()).toList();

		assertThat(result, hasSize(8));
	}

	@Test
	public void test_map_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre de clients associés aux commandes
		// long result = 0;
		long result = orders.stream().map(p -> p.getCustomer()).collect(Collectors.counting());

		assertThat(result, is(8L));
	}

	@Test
	public void test_map_distinct() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Trouver la liste des différents clients associés aux commandes (sans doublon)
		// List<Customer> result = null;
		List<Customer> result = orders.stream().map(p -> p.getCustomer()).distinct().toList();

		assertThat(result, hasSize(2));
	}

	@Test
	public void test_map_distinct_count() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO Compter le nombre des différents clients associés aux commandes
		// long result = 0L;
		long result = orders.stream().map(p -> p.getCustomer()).distinct().collect(Collectors.counting());

		assertThat(result, is(2L));
	}

	@Test
	public void test_mapToDouble_sum() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le chiffre d'affaires total de la pizzeria (somme des prix des
		 * commandes)
		 */
		// double result = 0.0;
		double result = orders.stream().mapToDouble(p -> p.getPrice()).sum();
		System.out.println(orders.get(0).getPrice());

		assertThat(result, is(10900.0));
	}

	@Test
	public void test_mapToDouble_avg() throws Exception {

		List<Order> orders = new Data().getOrders();

		/*
		 * TODO Calculer le prix moyen des commandes de la pizzeria
		 */
		// OptionalDouble result = null;
		OptionalDouble result = orders.stream().mapToDouble(p -> p.getPrice()).average();

		assertThat(result.isPresent(), is(true));
		assertThat(result.getAsDouble(), is(1362.5));
	}
}
