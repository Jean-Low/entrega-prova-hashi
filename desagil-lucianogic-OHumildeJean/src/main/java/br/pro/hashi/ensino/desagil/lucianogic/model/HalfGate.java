package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {


	private AndGate and;
	private XorGate xor;

	public HalfGate() {
		super(2, 2);

		name = "HALF";

		and = new AndGate();
		xor = new XorGate();

	}

	@Override
	public boolean doRead(int index) {
		
		return (index == 1 ? and.read() : xor.read());
		
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			and.connect(emitter, 0);
			xor.connect(emitter, 0);
			break;
		case 1:
			and.connect(emitter, 1);
			xor.connect(emitter, 1);
			break;
		}
	}
}
