
public class NoCard implements ATMState{

	ATMMachine atmMachine;
	public NoCard(ATMMachine newATMMachine){
		atmMachine = newATMMachine;
	}
	@Override
	public void insertCard() {
		System.out.println("Please Enter a PIN");
		atmMachine.setATMState(atmMachine.getYesCardState());
	}

	@Override
	public void ejectCard() {
		System.out.println("Enter a card first");
		
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("Enter a card first");
		
	}

	@Override
	public void requestCash(int cash) {
		System.out.println("Enter a card first");
		
	}

}
