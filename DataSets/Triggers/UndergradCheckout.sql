
DELIMITER $
CREATE TRIGGER `undergraduate_checkout_trigger` BEFORE INSERT ON `Transactions`
FOR EACH ROW
BEGIN

IF "UG" = (SELECT permissionLevel FROM group09.Users u WHERE NEW.userId = u.id)
THEN
	 SET @count = (SELECT COUNT(c.userId) FROM group09.Transactions c WHERE c.userId = NEW.userId AND checkedIn = 0);
     
	 IF @count > 2
	 THEN
		 SIGNAL SQLSTATE '42000'
		 SET MESSAGE_TEXT = 'Undergraduate student has too many books checked out';
	 END IF;
     
END IF;

END$ DELIMITER ;