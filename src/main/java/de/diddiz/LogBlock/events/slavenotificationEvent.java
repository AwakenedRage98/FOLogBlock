package de.diddiz.LogBlock.events;

import de.diddiz.LogBlock.LogBlock;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class slavenotificationEvent implements Listener{
    public PreparedStatement pst;
    public ResultSet rs;
    private final LogBlock logblock;
    public slavenotificationEvent(LogBlock lb)
    {
        logblock = lb;
    }
    public String getSlaveInfo(String rucase)
    {

        switch(rucase) {
            case "iostatus": {
                try {
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while (rs.next()) {
                        return rs.getString(1);
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                } catch (java.sql.SQLException ex) {

                    return ex.getMessage().toString();
                }

            }
            case "masterfile":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getString(6);
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "masterfilepos":
            {
                try{
                   // logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                   // logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(7).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "slaveiorunning":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(11).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "slavesqlrunning":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(12).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lasterrornum":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(19).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lasterror":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(20).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lastioerrornum":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(35).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lastioerror":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(36).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lastsqlerrornum":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(37).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }
            case "lastsqlerror":
            {
                try{
                    //logblock.getLogger().info("Preparing statement");
                    pst = logblock.pool.getConnection().prepareStatement("SHOW SLAVE STATUS;");
                    //logblock.getLogger().info("Executing query");
                    rs = pst.executeQuery();
                    //logblock.getLogger().info("Returning input");
                    while(rs.next())
                    {
                        return rs.getObject(38).toString();
                    }
                    return "INVALID";
                    //  return logblock.pool.executeQuery("SHOW VARIABLES like 'bind_address';").getString("Value");
                }
                catch(java.sql.SQLException ex)
                {

                    return ex.getMessage().toString();
                }
            }

        }
        return "invalid";

    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (logblock.getConfig().getInt(("fo.servers")) == 2) {

            if (event.getPlayer().isPermissionSet("logblock.fo.status") || event.getPlayer().isOp()) {
                if (getSlaveInfo("iostatus").equalsIgnoreCase("Reconnecting after a failed binlog dump request")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));

                }
                if (getSlaveInfo("iostatus").equalsIgnoreCase("Reconnecting after a failed master event read")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));


                }
                if (getSlaveInfo("iostatus").equalsIgnoreCase("Waiting for the slave SQL thread to free enough relay log space")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "The RelayLog has run out of space!!!!");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator immediately!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));

                }
                if (getSlaveInfo("iostatus").equalsIgnoreCase("Waiting to reconnect after a failed binlog dump request")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));

                }
                if (getSlaveInfo("iostatus").equalsIgnoreCase("Waiting to reconnect after a failed master event read")) {
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Your database slave is not connected to the master. It is currently not replicating...");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "For more info use the /lb slaveerrors commands");
                    event.getPlayer().sendRawMessage(ChatColor.RED + "Please contact your database administrator!");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));


                } else {
                    logblock.getLogger().info("Attempting 1");
                    event.getPlayer().sendRawMessage(ChatColor.GREEN + "FOLogblock Slave Status: ");
                    logblock.getLogger().info("Attempting 2");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "SLAVE IO Status: " + getSlaveInfo("iostatus"));
                    logblock.getLogger().info("Attempting 3");
                    //event.getPlayer().sendRawMessage(ChatColor.GOLD + "Master File: " + getSlaveInfo("masterfile"));
                    //logblock.getLogger().info("Attempting 4");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave IO Running: " + getSlaveInfo("slaveiorunning"));
                    logblock.getLogger().info("Attempting 5");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Slave SQL Running: " + getSlaveInfo("slavesqlrunning"));
                    logblock.getLogger().info("Attempting 6");
                    //event.getPlayer().sendRawMessage(ChatColor.GOLD + "Last ErrorCode : " + getSlaveInfo("lasterrornum"));
                    /*logblock.getLogger().info("Attempting 7");
                    //event.getPlayer().sendRawMessage(ChatColor.GOLD + "Last Error : " + getSlaveInfo("lasterror"));
                    logblock.getLogger().info("Attempting 8");
                    event.getPlayer().sendRawMessage(ChatColor.GOLD + "Last IO Error : " + getSlaveInfo("lastioerror"));
                    logblock.getLogger().info("Attempting 9");
                    //event.getPlayer().sendRawMessage(ChatColor.GOLD + "Last SQL Errorcode : " + getSlaveInfo("lastsqlerrornum"));
                    //event.getPlayer().sendRawMessage(ChatColor.GOLD + "Last SQL Error : " + getSlaveInfo("lastsqlerror"));
                */
                }

            }
        }
    }
}
