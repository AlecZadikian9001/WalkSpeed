package com.alecz.walkspeed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_5_R3.command.ColouredConsoleSender;
import org.bukkit.entity.*;

public class WSCommandHandler implements CommandExecutor {
	Player target;
	float input;
	String speed;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias,
			String[] args) {

		if (sender.isOp()){

			if (cmd.getName().equalsIgnoreCase("walkspeed")){

				input = (float) .2;

				if (args.length<=0){
					return false;
				}

				target = sender.getServer().getPlayer(args[0]);

				if (target == null){
					sender.sendMessage("The player "+args[0]+" is not online.");
					return false;
				}

				else if (args.length==2){
					try{ 
						input = Float.parseFloat(args[1]); 
						if (input<-1 || input>1){
							sender.sendMessage("Speed must be between -1 and 1.");
							return false;
						}
						if (input!=.2) speed = args[1];
						else speed = "default";
					}
					catch (Exception e){ sender.sendMessage("Invalid value specified for speed."); }
				}
				else if (args.length==1) speed = "default";
				else return false;

				target.setWalkSpeed(input);
				sender.sendMessage("Set the walk speed to "+speed+" for player "+args[0]);
				if (!target.equals(sender)) target.sendMessage(""+sender.getName()+" has set your walk speed to "+speed+".");

				return true;
			}
			
			else if (cmd.getName().equalsIgnoreCase("flyspeed")){

				input = (float) .1;

				if (args.length<=0){
					return false;
				}

				target = sender.getServer().getPlayer(args[0]);

				if (target == null){
					sender.sendMessage("The player "+args[0]+" is not online.");
					return false;
				}

				else if (args.length==2){
					try{ 
						input = Float.parseFloat(args[1]); 
						if (input<-1 || input>1){
							sender.sendMessage("Speed must be between -1 and 1.");
							return false;
						}
						if (input!=.1) speed = args[1];
						else speed = "default";
					}
					catch (Exception e){ sender.sendMessage("Invalid value specified for speed."); }
				}
				else if (args.length==1) speed = "default";
				else return false;

				target.setFlySpeed(input);
				sender.sendMessage("Set the fly speed to "+speed+" for player "+args[0]);
				if (!target.equals(sender)) target.sendMessage(""+sender.getName()+" has set your fly speed to "+speed+".");

				return true;
			}

		}
		return true;
	}
}
