FOLogblock
==========
FOLogblock is a fork of Logblock that allows the use of failover database connections with seamless handoff between replicating database servers.


What is LogBlock?
==========

This plugin logs block changes such as breaking, placing, modifying, or burning to a MySQL Database. It can be used as an anti-griefing tool to find out who made a particular edit, or even roll back changes by certain players.
Originally written by bootswithdefer, for hMod, ported to Bukkit by me, because of the inability to identfy griefers. BigBrother also did't work, so I was forced to do it myself. The honor belongs to bootswithdefer for the sourcecode, I only spent about 8 hours to transcribe. All functions except sign text logging shold work as in hMod. The use of permissions plugin is possible, but not necessary.

Questioner: http://git.io/u2MxKQ


FOLogblock Changelog V0.5.3.2
==========
- Fixed a permission issue with the repip command.
- Fixed an permission issue with the master command.
- Added a logblock.replication permission node
- Added a Master Status command, that is verified to work correctly.
- Added a repip command that allows you to see what IP the MySQL server is currently binded to.
- Added a default permission for the replication commands to be for ops only.


