native CE_Convert(const string[]);
native CE_Convert_Dialog(const string[], style = 0);
native CE_CountTag(const string[]);

stock CE_SendClientMessage(playerid, color, const text[], {Float, _}:...)
{
	static
	    args,
	    str[144];

	if ((args = numargs()) == 3)
	{
		CE_Convert(text);
		SendClientMessage(playerid, color, text);
	}
	else
	{
		while (--args >= 3)
		{
			#emit LCTRL 5
			#emit LOAD.alt args
			#emit SHL.C.alt 2
			#emit ADD.C 12
			#emit ADD
			#emit LOAD.I
			#emit PUSH.pri
		}
		#emit PUSH.S text
		#emit PUSH.C 144
		#emit PUSH.C str
		#emit PUSH.S 8
		#emit SYSREQ.C format
		#emit LCTRL 5
		#emit SCTRL 4

		CE_Convert(str);
		SendClientMessage(playerid, color, str);

		#emit RETN
	}
	return 1;
}

stock CE_SendClientMessageToAll(color, const text[], {Float, _}:...)
{
	static
	    args,
	    str[144];

	if ((args = numargs()) == 2)
	{
		CE_Convert(text);	
	    SendClientMessageToAll(color, text);
	}
	else
	{
		while (--args >= 2)
		{
			#emit LCTRL 5
			#emit LOAD.alt args
			#emit SHL.C.alt 2
			#emit ADD.C 12
			#emit ADD
			#emit LOAD.I
			#emit PUSH.pri
		}
		#emit PUSH.S text
		#emit PUSH.C 144
		#emit PUSH.C str
		#emit LOAD.S.pri 8
		#emit ADD.C 4
		#emit PUSH.pri
		#emit SYSREQ.C format
		#emit LCTRL 5
		#emit SCTRL 4

		CE_Convert(str);	
		SendClientMessageToAll(color, str);

		#emit RETN
	}
	return 1;
}

stock CE_ShowPlayerDialog(playerid, dialogid, style, caption[], info[], button1[], button2[]) {	
	CE_Convert(caption);
	CE_Convert_Dialog(info, style);
	return ShowPlayerDialog(playerid, dialogid, style, caption, info, button1, button2);
}	


stock Text3D:CE_Create3DTextLabel(text[], color, Float:X, Float:Y, Float:Z, Float:DrawDistance, virtualworld = -1, testLOS = 0) {	
	CE_Convert(text);
	new Text3D:ce_3dtextid = Create3DTextLabel(text, color, X, Y, Z, DrawDistance, virtualworld, testLOS);	
	return ce_3dtextid;
}

stock CE_Update3DTextLabelText(Text3D:id, color, text[]) {
	CE_Convert(text);
	Update3DTextLabelText(id, color, text);
}


#if defined CE_AUTO	

	#if defined _streamer_included

		#if defined CreateDynamic3DTextLabel
			stock STREAMER_TAG_3D_TEXT_LABEL:CE_CreateDynamic3DTextLabel(const text[], color, Float:x, Float:y, Float:z, Float:drawdistance, attachedplayer = INVALID_PLAYER_ID, attachedvehicle = INVALID_VEHICLE_ID, testlos = 0, worldid = -1, interiorid = -1, playerid = -1, Float:streamdistance = STREAMER_3D_TEXT_LABEL_SD, areaid = -1, priority = 0)	
			{	
				CE_Convert(text);	
				new  STREAMER_TAG_3D_TEXT_LABEL:ce_3dtextid = CreateDynamic3DTextLabel(text, color, x, y, z, drawdistance, attachedplayer, attachedvehicle, testlos, worldid, interiorid, playerid, streamdistance, areaid, priority);	
				return ce_3dtextid;	
			}
			#if defined _ALS_CreateDyn3DTextLabel
				#undef CreateDynamic3DTextLabel
			#else	
				#define _ALS_CreateDyn3DTextLabel
			#endif
			#define CreateDynamic3DTextLabel CE_CreateDynamic3DTextLabel
		#endif

		#if defined UpdateDynamic3DTextLabelText
			stock CE_UpdateDynamic3DTextLabelText(STREAMER_TAG_3D_TEXT_LABEL:id, color, const text[])
			{	
				CE_Convert(text);	
				UpdateDynamic3DTextLabelText(id, color, text);		
			}
			#if defined _ALS_UpdateDyn3DTextLabelText
				#undef UpdateDynamic3DTextLabelText
			#else	
				#define _ALS_UpdateDyn3DTextLabelText
			#endif		
			#define UpdateDynamic3DTextLabelText CE_UpdateDynamic3DTextLabelText
		#endif
	#endif

	#if defined _ALS_Create3DTextLabel
		#undef Create3DTextLabel	
	#else	
		#define _ALS_Create3DTextLabel
	#endif	
	#define Create3DTextLabel CE_Create3DTextLabel

	#if defined _ALS_Update3DTextLabelText
		#undef Update3DTextLabelText	
	#else	
		#define _ALS_Update3DTextLabelText
	#endif	
	#define Update3DTextLabelText CE_Update3DTextLabelText

	#if defined _ALS_ShowPlayerDialog	
		#undef ShowPlayerDialog	
	#else	
		#define _ALS_ShowPlayerDialog	
	#endif	

	#define ShowPlayerDialog CE_ShowPlayerDialog	

	#if defined _ALS_SendClientMessage	
		#undef SendClientMessage	
	#else	
		#define _ALS_SendClientMessage	
	#endif	
	#define SendClientMessage CE_SendClientMessage


	#if defined _ALS_SendClientMessageToAll
		#undef SendClientMessageToAll
	#else	
		#define _ALS_SendClientMessageToAll
	#endif	
	#define SendClientMessageToAll CE_SendClientMessageToAll
 #endif
