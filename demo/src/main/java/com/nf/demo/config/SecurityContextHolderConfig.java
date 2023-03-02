//package com.nf.demo.config;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class SecurityContextHolderConfig {
//    public String getLoggedInUserName() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
//        return authentication.getName();
//    }
//}
