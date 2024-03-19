package com.examples.cassandra.util;

import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

// Cassandra connector
@Component
public class CassandraConnector {

	private Cluster cluster;

	private Session session;
	
	public CassandraConnector() {
		Builder b = Cluster.builder().addContactPoint("127.0.0.1").withPort(9042).withoutJMXReporting();

		cluster = b.build();

		session = cluster.connect("javacassandra");		
	}

	public Session getSession() {
		return this.session;
	}

	public void close() {
		session.close();
		cluster.close();
	}
}