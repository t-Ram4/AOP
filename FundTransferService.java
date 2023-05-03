	class FundTransferService{

	public void transferFund(Account fromAccount, Account toAccount,float amount,Principal user){

	try{
	//Authenticate the user
	SecurityService.authenticateUser(user);

	//intitiate transaction
	TransactionService.openTransaction();

	//withdraw money from first account
	withdrawMoney(fromAccount,amount);

	//credit money to second account
	creditMoney(toAccount,amount);

	//log the info
	LoggingService.info(transaction completed successfully);

	TransactionService.commit();

	}
	catch(Exception e){
	
	LoggingService.log("Transaction failed"+e);

	}

	finally{
	
	TransactionService.closeTransaction();
	
	}



}






}