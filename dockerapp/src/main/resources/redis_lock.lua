local key = KEYS[1]
local value = KEYS[2]
local sec = KEYS[3]

local result = redis.call("SET",key, value, "NX", "EX", sec)
if(result) then
	return 1
else
	return 0;
end

