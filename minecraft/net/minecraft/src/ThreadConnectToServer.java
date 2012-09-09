package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;

class ThreadConnectToServer extends Thread
{
    /** The IP address or domain used to connect. */
    final String ip;

    /** The port used to connect. */
    final int port;

    /** A reference to the GuiConnecting object. */
    final GuiConnecting connectingGui;

    ThreadConnectToServer(GuiConnecting par1GuiConnecting, String par2Str, int par3)
    {
        this.connectingGui = par1GuiConnecting;
        this.ip = par2Str;
        this.port = par3;
    }

    public void run()
    {
        try
        {
        	System.out.println("1");
            GuiConnecting.setNetClientHandler(this.connectingGui, new NetClientHandler(GuiConnecting.func_74256_a(this.connectingGui), this.ip, this.port));
            System.out.println("2");
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
            	System.out.println("3");
                return;
            }
            System.out.println("4");
            GuiConnecting.getNetClientHandler(this.connectingGui).addToSendQueue(new Packet2ClientProtocol(39, GuiConnecting.func_74254_c(this.connectingGui).session.username, this.ip, this.port));
            System.out.println("5");
        }
        catch (UnknownHostException var2)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
            	System.out.println("6");
                return;
            }
            System.out.println("7");
            GuiConnecting.func_74249_e(this.connectingGui).displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {"Unknown host \'" + this.ip + "\'"}));
            System.out.println("8");
        }
        catch (ConnectException var3)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
            	System.out.println("9");
                return;
            }
            System.out.println("10");
            GuiConnecting.func_74250_f(this.connectingGui).displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {var3.getMessage()}));
            System.out.println("11");
        }
        catch (Exception var4)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
            	System.out.println("12");
                return;
            }
            System.out.println("13");
            var4.printStackTrace();
            GuiConnecting.func_74251_g(this.connectingGui).displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {var4.toString()}));
            System.out.println("14");
        }
    }
}
