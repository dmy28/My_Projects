--------------------------------------------
-- Module Name: Convertor
--------------------------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

library UNISIM;
use UNISIM.VComponents.all;

Entity convertor Is
port (
		b : in STD_LOGIC_VECTOR(7 downto 0);
		g : out STD_LOGIC_VECTOR(7 downto 0)
	);
end convertor;

Architecture behavior of convertor Is

Signal led_int : STD_LOGIC_VECTOR(7 downto 0) := "00000000";

begin
      
        g(7) <= b(7);
		g(6) <= b(7) xor b(6);
		g(5) <= b(6) xor b(5);
		g(4)<=b(5) xor b(4);
		g(3)<=b(4) xor b(3);
		g(2)<=b(3) xor b(2);
		g(1)<=b(2) xor b(1);
		g(0)<=b(1) xor b(0);
		

end behavior;
		

