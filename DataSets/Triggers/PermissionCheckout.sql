DELIMITER $
CREATE TRIGGER `checkout_period` AFTER INSERT ON `Transactions`
FOR EACH ROW
BEGIN
	UPDATE Transactions SET expectedCheckInDate = checkOutDate + 
		(
        SELECT p.checkoutPeriod 
        FROM Permissions p
        JOIN Users u ON u.permissionLevel = p.permissionLevel
        WHERE u.is = NEW.userId
		)
	WHERE id = NEW.id AND expectedCheckInDate IS NULL;
END$ DELIMITER;