package com.margin.java.ldap;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.*;

public class LdapProtocolManager {

    public List<Map<String, String>> read() throws NamingException {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        // set up environment
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389");

        // authentication
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "id");
        env.put(Context.SECURITY_CREDENTIALS, "password");

        // create initial context
        LdapContext context = new InitialLdapContext(env, null);

        // set up search condition
        String searchName = "OU=ldap,DC=java,DC=margin,DC=com";
        String searchFilter = "(objectClass = * )"; // 모든 개체 검색
        String[] returningAttributes = {"objectGUID", "cn"};

        SearchControls sc = new SearchControls();
        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        sc.setReturningAttributes(returningAttributes);

        NamingEnumeration<SearchResult> searchResults = context.search(searchName, searchFilter, sc);

        // see search results
        while (searchResults.hasMoreElements()) {
            SearchResult sr = searchResults.nextElement();
            Attributes attr = sr.getAttributes();

            String objectGUID = attr.get("objectGUID").get().toString();
            String cn = attr.get("cn").get().toString();

            Map<String, String> map = new HashMap<>();
            map.put("objectGUID", objectGUID);
            map.put("cn", cn);

            result.add(map);
        }


        context.close();

        return result;
    }
}
