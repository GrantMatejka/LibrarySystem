package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Book;

public interface BookDao extends Dao<Book> {
    //Method signatures for gathering data on books goes here

    public Set<Book> getSearchedBooks(String title, String author, String category) {
        Set<Book> books = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if(category != null)
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Books WHERE title LIKE '%%s%' " +
                    "AND author LIKE '%%s%' AND category = '%s'", title, author, category);
            else
                preparedStatement = this.conn.prepareStatement("SELECT * FROM Books WHERE title LIKE '%%s%' " +
                        "AND author LIKE '%%s%'", title, author);
            resultSet = preparedStatement.executeQuery();
            books = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}