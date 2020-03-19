DELIMITER $
CREATE TRIGGER `update_extend_trigger` AFTER UPDATE ON `Transactions`
FOR EACH ROW
BEGIN

IF new.extend = 1 AND old.extend = 0
THEN 
    IF "GR" = (SELECT permissionLevel FROM group09.Users u WHERE NEW.userId = u.id)
    THEN 
		UPDATE Transaction t SET t.expectedCheckInDate = t.expectedCheckInDate + 14 WHERE NEW.userId = t.userId AND NEW.bookId = t.bookId;

    END IF;
    
    IF "UG" = (SELECT permissionLevel FROM group09.Users u WHERE NEW.userId = u.id)
    THEN 
		UPDATE Transaction t SET t.expectedCheckInDate = t.expectedCheckInDate + 7 WHERE NEW.userId = t.userId AND NEW.bookId = t.bookId;
    END IF;
END IF;

END$ 
DELIMITER ;