-module(tut3).
-export([convert_length/1]).
-export([list_length/1]).

%% Tuples allow us to group things together to make things more understandable.
%% This lets the caller, for example, pass in the type of the "X" parameter to improve readability
convert_length({centimeter, X}) ->
    {inch, X / 2.54};
convert_length({inch, Y}) ->
    {centimeter, Y * 2.54}.


%% Lists are done with "[" and "]" and match like "[A, B | C] = [1, 2, 3, 4]." (C would = [3, 4])
list_length([]) -> 
    0;
list_length([First | Rest]) ->
    1 + list_length(Rest).
