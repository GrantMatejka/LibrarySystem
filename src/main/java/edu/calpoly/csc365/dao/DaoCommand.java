package edu.calpoly.csc365.dao;

public interface DaoCommand {
    Object execute(DaoManager daoManager);
}