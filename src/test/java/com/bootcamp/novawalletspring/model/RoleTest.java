package com.bootcamp.novawalletspring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void testRoleAdmin() {
        Role adminRole = Role.ROLE_ADMIN;
        assertNotNull(adminRole);
        assertEquals("ROLE_ADMIN", adminRole.name());
        assertEquals(0, adminRole.ordinal());
    }

    @Test
    void testRoleUser() {
        Role userRole = Role.ROLE_USER;
        assertNotNull(userRole);
        assertEquals("ROLE_USER", userRole.name());
        assertEquals(1, userRole.ordinal());
    }

    @Test
    void testValueOf() {
        Role adminRole = Role.valueOf("ROLE_ADMIN");
        Role userRole = Role.valueOf("ROLE_USER");

        assertEquals(Role.ROLE_ADMIN, adminRole);
        assertEquals(Role.ROLE_USER, userRole);
    }

    @Test
    void testValues() {
        Role[] roles = Role.values();
        assertEquals(2, roles.length);
        assertEquals(Role.ROLE_ADMIN, roles[0]);
        assertEquals(Role.ROLE_USER, roles[1]);
    }
}