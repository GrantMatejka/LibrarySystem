DELIMITER $
CREATE TRIGGER `checkout_period` BEFORE INSERT ON `Transactions`
FOR EACH ROW
BEGIN
	SET NEW.expectedCheckInDate = NEW.checkOutDate + 
		(
        SELECT p.checkoutPeriod 
        FROM Permissions p
        JOIN Users u ON u.permissionLevel = p.permissionLevel
        WHERE u.id = NEW.userId
		);

END$ DELIMITER ;
