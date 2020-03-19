use group09;
drop trigger  checkout_period;

DELIMITER $
CREATE TRIGGER `checkout_period` BEFORE INSERT ON `Transactions`
FOR EACH ROW
BEGIN
	SET NEW.expectedCheckInDate = DATE_ADD(NEW.checkOutDate, INTERVAL
		(
        SELECT p.checkoutPeriod 
        FROM Permissions p
        JOIN Users u ON u.permissionLevel = p.permissionLevel
        WHERE u.id = NEW.userId
		) DAY);

END$ DELIMITER ;
