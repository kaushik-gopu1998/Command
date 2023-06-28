package com.commandpattern.client;

import com.commandpattern.command.Command;
import com.commandpattern.command.LightOffCommand;
import com.commandpattern.command.LightOnCommand;
import com.commandpattern.command.MacroCommand;
import com.commandpattern.command.StereoOffCommand;
import com.commandpattern.command.StereoOnCommand;
import com.commandpattern.invoker.RemoteControl;
import com.commandpattern.receiver.Light;
import com.commandpattern.receiver.Stereo;

public class Client {
	public static void main(String[] args) {
		Light light = new Light("living room");
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		Stereo stereo = new Stereo("living room");
		StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
		StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
		remoteControl.setCommand(1, stereoOnCommand, stereoOffCommand);
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		Command[] onCommands = {lightOnCommand,stereoOnCommand};
		Command[] offCommands = {lightOffCommand,stereoOffCommand};
		MacroCommand macroOnCommand = new MacroCommand(onCommands);
		MacroCommand macroOffCommand = new MacroCommand(offCommands);
		remoteControl.setCommand(0,macroOnCommand,macroOffCommand);
		System.out.println("Macro Command Execution Started......");
		remoteControl.onButtonWasPushed(0);
		remoteControl.undoButtonWasPushed(0);
		System.out.println("Macro Command Execution Ended..........");	
	}
}
