DELIMITER $
CREATE TRIGGER `graduate_checkout_trigger` BEFORE INSERT ON `Transactions`
FOR EACH ROW
BEGIN

IF "GR" = (SELECT permissionLevel FROM group09.Users u WHERE NEW.userId = u.id)
THEN
	 SET @count = (SELECT COUNT(c.userId) FROM group09.Transactions c WHERE c.userId = NEW.userId AND checkedIn = 0);
     
	 IF @count > 5
	 THEN
		 SIGNAL SQLSTATE '42100'
		 SET MESSAGE_TEXT = 'Graduate student has too many books checked out';
	 END IF;
     
END IF;

END$ DELIMITER ;