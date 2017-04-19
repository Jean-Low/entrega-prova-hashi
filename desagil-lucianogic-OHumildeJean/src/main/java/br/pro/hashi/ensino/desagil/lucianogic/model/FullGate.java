package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {

	//variables names based on position on the schematics
	private AndGate andUp, andDown;
	private XorGate xorUp, xorDown;
	private OrGate or;

	public FullGate() {
		super(3, 2);

		name = "FULL";

		andUp = new AndGate();
		andDown = new AndGate();
		xorUp = new XorGate();
		xorDown = new XorGate();
		or = new OrGate();
		
		andUp.connect(xorUp, 0);
		xorDown.connect(xorUp, 0);
		or.connect(andUp, 0);
		or.connect(andDown, 1);
	}

	@Override
	public boolean doRead(int index) {
		
		return (index == 0 ? xorDown.read() : or.read());
		
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			xorUp.connect(emitter, 0);
			andDown.connect(emitter, 0);
			break;
		case 1:
			xorUp.connect(emitter, 1);
			andDown.connect(emitter, 1);
			break;
		case 2:
			xorDown.connect(emitter, 1);
			andUp.connect(emitter, 1);
			break;
		}
	}
}
