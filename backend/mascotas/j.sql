Select *  

from dbo.[catalogo.Cliente] c, dbo.[movimientos.Pedido] cp  

where fecha_pedido='01-01-2000' and  

c.numeroCliente=1 and c.numeroCliente=cp.numeroCliente; 

GO 

Select * from [catalogo.Cliente] where numeroCliente=1 and numeroCliente  

in (select  numeroCliente from [movimientos.Pedido] where fecha_pedido='01-01-2000' ); 

GO 

Select  * from [catalogo.Cliente] c inner join [movimientos.Pedido] cp on  

c.numeroCliente=cp.numeroCliente  where fecha_pedido='01-01-2000' and cp.numeroCliente=1 

GO 

  

  

Select  * into #temp from [movimientos.Pedido] where fecha_pedido='01-01-2000'; 

Go 

Select * from [catalogo.Cliente] c, #temp t where c.numeroCliente=t.numeroCliente and  

c.numeroCliente=1  