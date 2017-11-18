package de.diddiz.LogBlock.events;

import de.diddiz.LogBlock.LogBlock;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class slavenotificationEvent implements Listener {
    public PreparedStatement pst;
    public ResultSet rs;
    public String returnoutput;
    public String iostatus;
    public String masterfile;
    public String masterfilepos;
    public String slaveIO;
    public String SlaveSQL;
    private final LogBlock logblock;

    public slavenotificationEvent(LogBlock lb) {
        logblock = lb;
    }

    public void setIOStatus(String status)
    {
        iostatus = status;
    }
    public void setMasterFile(String file)
    {
        masterfile = file;
    }
    public void setSlaveIOState(String state)
    {
       slaveIO = state;
    }
    public void setSlaveSQLState(String state)
    {
        SlaveSQL = state;
    }
    public void setMasterFilePos(String pos)
    {
        masterfilepos = pos;
    }
    public void PrepareInfo() {
        try {
            //logblock.getLogger().info("Preparing statement");
            pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
            //logblock.getLogger().info("Executing query");
            rs = pst.executeQuery();
            //logblock.getLogger().info("Returning input");
            while (rs.next()) {
                 setIOStatus(rs.getString(1));
                 setMasterFile(rs.getString(6));
                 setMasterFilePos(rs.getObject(7).toString());
                 setSlaveIOState(rs.getObject(11).toString());
                 setSlaveSQLState(rs.getObject(12).toString());

                rs.close();
            }
        }
        catch(java.sql.SQLException ex)
        {

        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (logblock.getConfig().getInt(("fo.servers")) == 2) {

            if (event.getPlayer().isPermissionSet("logblock.fo.status") || event.getPlayer().isOp()) {
                PrepareInfo();
                if (iostatus.equalsIgnoreCase("Reconnecting after a failed binlog dump request")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);

                }
                if (iostatus.equalsIgnoreCase("Reconnecting after a failed master event read")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);


                }
                if (iostatus.equalsIgnoreCase("Waiting for the slave SQL thread to free enough relay log space")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "The RelayLog has run out of space!!!!");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator immediately!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);

                }
                if (iostatus.equalsIgnoreCase("Waiting to reconnect after a failed binlog dump request")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);

                }
                if (iostatus.equalsIgnoreCase("Waiting to reconnect after a failed master event read")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);

                } else {
                    event.getPlayer().sendRawMessage( ChatColor.GREEN + "FOLogblock Status: ");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + iostatus);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + masterfile);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + slaveIO);
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + SlaveSQL);
                }

            }
        }
    }
}
